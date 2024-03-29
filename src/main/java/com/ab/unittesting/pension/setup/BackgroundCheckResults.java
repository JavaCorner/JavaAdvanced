package com.ab.unittesting.pension.setup;

/**
 * @author Arpit Bhardwaj
 */
public class BackgroundCheckResults {

    private String riskProfile;
    private long upperAccountLimit;

    public BackgroundCheckResults(String riskProfile, long upperAccountLimit) {
        this.riskProfile = riskProfile;
        this.upperAccountLimit = upperAccountLimit;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public long getUpperAccountLimit() {
        return upperAccountLimit;
    }
}
