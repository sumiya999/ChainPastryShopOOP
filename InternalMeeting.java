/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrbaker;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class InternalMeeting implements Serializable {
    protected int meetingID;
    protected String meetingName;
    protected LocalDate meetingTime;
    
    public InternalMeeting(int meetingID, String meetingName, LocalDate meetingTime) {
        this.meetingID = meetingID;
        this.meetingName = meetingName;
        this.meetingTime = meetingTime;
    }
    
    public String toString() {
        return "Meeting ID: " + meetingID + ", Meeting Agenda: " + meetingName + ", Meeting Date: " + meetingTime + "}\n";
    }    
}
    
