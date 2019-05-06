package com.akhambir.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACTIONS")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Embedded
    //private ActionCriteria actionCriteria;
    @Column(name = "FROM_DATE")
    private LocalDate from;
    @Column(name = "UNTIL_DATE")
    private LocalDate until;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public ActionCriteria getActionCriteria() {
        return actionCriteria;
    }

    public void setActionCriteria(ActionCriteria actionCriteria) {
        this.actionCriteria = actionCriteria;
    }*/

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        CREATED, IN_PROGRESS, DONE
    }
}
