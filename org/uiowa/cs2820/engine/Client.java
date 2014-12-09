package org.uiowa.cs2820.engine;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONTokener;

/**
 * This class is meant to be used with a server that expects a form
 * and response by sending an encoded JSON structure containing the 
 * information from server back to client.
 *
 * (quite vague, no real purpose, but can be extended into something
 * that could be quite useful)
 * 
 * The point of this client is just to show how the Jersey RESTful API
 * is suited to Java program communicating with each other.
 * 
 * Input: a servers's URI (like http://localhost:8000) and a sequence of 
 *        strings to be put into a JSON list, which is then sent to
 *        the server.
 */
public class Client {
        public Client(String URI, String[] args) {
                javax.ws.rs.client.Client client = ClientBuilder.newClient();
                WebTarget webTarget = client.target(URI);
                WebTarget resourceWebTarget = webTarget.path("Catenate");
                Invocation.Builder invocationBuilder = 
                                resourceWebTarget.request(MediaType.APPLICATION_JSON);
                JSONArray transaction = new JSONArray();
                for (String s: args) { transaction.put(s); }
                String eTrans = transaction.toString();
                Entity<String> requestOne = 
                                Entity.entity(eTrans,MediaType.APPLICATION_JSON);       
                Response eResponse = invocationBuilder.put(requestOne);
                String preJSON = eResponse.readEntity(String.class);
                // System.out.println("Raw response is \n"+preJSON);
                JSONTokener P = new JSONTokener(preJSON);
                JSONArray D = new JSONArray(); // empty by default
                try { D = new JSONArray(P); }
                catch (JSONException j) {};
                for (int i=0; i<D.length(); i++) {
                        String e = "**non-string**";
                        try { e = D.getString(i); }
                        catch (JSONException j) {};
                        System.out.println("response position " + i + " equals " + e);
                    }
                }
        }
