/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mountKabru.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wilbur
 */
public class Event implements Serializable{
    
    String eventType;
    String locationType;
    String eventName;
    String eventDescription;
    Actor[] actors;
    int[] goldEvent;

    public Event(String eventType, String locationType, String eventName, String eventDescription, Actor[] actors, int[] goldEvent) {
        this.eventType = eventType;
        this.locationType = locationType;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.actors = actors;
        this.goldEvent = goldEvent;
    }

    


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Actor[] getActors() {
        return actors;
    }

    public int[] getGoldEvent() {
        return goldEvent;
    }

    public void setGoldEvent(int[] goldEvent) {
        this.goldEvent = goldEvent;
    }

    
    }
