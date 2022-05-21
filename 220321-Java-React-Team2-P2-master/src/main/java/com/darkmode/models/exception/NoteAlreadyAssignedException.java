package com.darkmode.models.exception;

import java.text.MessageFormat;

public class NoteAlreadyAssignedException extends RuntimeException{
    public NoteAlreadyAssignedException(final Long note_id, final Long user_id){
        super(MessageFormat.format("Item: {0} is already assigned to user: {1}", note_id, user_id));
    }
}