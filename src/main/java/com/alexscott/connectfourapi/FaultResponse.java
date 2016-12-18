package com.alexscott.connectfourapi;

/**
 * Wrap an exception into JSON.
 */
public class FaultResponse {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
