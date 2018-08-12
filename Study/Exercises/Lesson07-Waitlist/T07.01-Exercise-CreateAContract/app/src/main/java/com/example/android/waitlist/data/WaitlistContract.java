package com.example.android.waitlist.data;

import android.provider.BaseColumns;

public class WaitlistContract {
    // COMPLETE (1) Create an inner class named WaitlistEntry class that implements the BaseColumns interface
    public class WaitlistEntry implements BaseColumns {
        // COMPLETE (2) Inside create a static final members for the table name and each of the db columns
        static final String TABLE_NAME = "waitlist";
        static final String COLUMN_GUEST_NAME = "guestName";
        static final String COLUMN_PARTY_SIZE = "partySize";
        static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
