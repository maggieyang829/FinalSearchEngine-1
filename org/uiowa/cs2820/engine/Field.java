package org.uiowa.cs2820.engine;

import java.io.*;

public class Field implements Serializable {
  // Field has a name and an associated value
  private String FieldName; 
  private Object FieldValue;
  // constructor for Field 
  public Field(String FieldName, Object Value) {
    this.FieldName = FieldName;
    this.FieldValue = Value;
    }
  public String getFieldName() { return FieldName; }
  public Object getFieldValue() { return FieldValue; }
  // this compares two Field objects for equality 
  public boolean equals(Field other) {
    return FieldName.equals(other.FieldName) & 
	   FieldValue.equals(other.FieldValue);
    }
  // compare Fields for GreaterThanSearch
  // this is giving weird results... need to fix
  public boolean greaterThan(Field other) {
	  return (FieldName.equals(other.FieldName)) & (FieldValue.toString().compareTo(other.FieldValue.toString())>0);
	  /*if (FieldName.equals(other.FieldName)) {
		  if (FieldValue.toString().compareTo(other.FieldValue.toString())>0) {
			  System.out.println(FieldValue.toString() + " > " + other.FieldValue.toString());
			  return true;
		  }
	  }
	  System.out.println(FieldValue.toString() + " < " + other.FieldValue.toString());
	  int t;
	  t = "an".compareTo("ankle");
	  System.out.println("t is " + t);
	  return false;
	  */
	  }
  // compare Fields for LessThanSearch
  // this is giving weird results... need to fix
  public boolean lessThan(Field other) {
	  return (FieldName.equals(other.FieldName)) & (FieldValue.toString().compareTo(other.FieldValue.toString())<0);
  }
	  
  public String toString() {
    return FieldName + ':' + FieldValue.toString();
    }
  }