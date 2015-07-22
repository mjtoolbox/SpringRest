package com.mjtoolbox.service;

import com.mjtoolbox.bean.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-06-25.
 */
@Service
public class SpringRestService {

    private static List<Message> messageList = new ArrayList<Message>();

    public List<Message> getAllEvents() {
        if ( messageList.size() == 0) {
            messageList.add(new Message("", 12345L, "ALU", "Instruction Pending", "Testing Instruction creation", new Date(), new Date(), "MJ", "Pending"));
            messageList.add(new Message("", 12346L, "JHT", "Implementation Created", "Testing", new Date(), new Date(), "WISPSOSE", "Submitted"));
            messageList.add(new Message("", 12347L, "SFL", "Instruction Pending", "Testing Instruction send", new Date(), new Date(), "HLPPSOSE", "Pending"));
            messageList.add(new Message("", 12348L, "CQD", "Instruction Sent", "Instruction was sent", new Date(), new Date(), "PSOSE", "Sent"));
            messageList.add(new Message("", 12349L, "PCN", "Instruction Pending", "Testing Instruction send", new Date(), new Date(), "WISPSOSE", "Pending"));
        }
        return messageList;
    }

    public void addEvent(Message event) {
        messageList.add(event);
    }

    public void deleteEventById(Long id) {
        Message found = findMessageById(id);
        if (found != null) {
            messageList.remove(found);
            id--;
        }
    }

    public void updateEvent(Message event) {
        Message found = findMessageById(event.getId());
        if (found != null) {
            messageList.remove(found);
            messageList.add(event);
        }
    }

    public void deleteAll() {
        messageList.clear();
    }


    private Message findMessageById(Long id) {
        for (Message ms : messageList) {
            if (ms.getId() == id) {
                return ms;
            }
        }
        return null;
    }

}
