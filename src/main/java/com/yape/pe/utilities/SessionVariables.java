package com.yape.pe.utilities;

public enum SessionVariables {
  SESSION_ACCOMMODATION("Session accommodation"),
  SESSION_TOTAL_PERSONAL_INFORMATION("Session total accommodation screen"),
  SESSION_PERSONAL("Session personal information"),
  SESSION_TOTAL_SUMMARY("Session total summary screen");

  private String variableName;

  SessionVariables(String variableName) {
    this.variableName = variableName;
  }

  public String getVariableName() {
    return variableName;
  }
}
