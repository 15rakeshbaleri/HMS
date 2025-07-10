package com.HMS.Hostel_Mng_Sys.model;

public enum Designation_staff {
    ADMIN("Admin"),
    WARDEN("Warden"),
    HOUSEKEEPING("Housekeeping Staff"),
    SECURITY("Security Staff"),
    MESS("Mess Staff"),
    MAINTENANCE("Maintenance Staff"),
    ACCOUNTANT("Accountant"),
    SUPPORT("Support Staff"),
    HELPER("Helper"),
    STUDENT("Student");

    private final String designationName;

    // Constructor to assign the designation name
    private Designation_staff(String designationName) {
        this.designationName = designationName;
    }

    // Getter method to retrieve the designation name
    public String getDesignationName() {
        return this.designationName;
    }
}