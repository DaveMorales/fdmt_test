package com.fdmt.bancomer.resposnes;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * ListMov is part of the POJOs to parse the response we would get from the server.
 */

public class ListMov implements Serializable {

    private String idMovement;
    private Long dateCreate;
    private String phoneOrigin;
    private String phoneDestination;
    private Double amount;
    private String message;
    private String status;
    private String tipoDisp;
    private String ctaOrigen;
    private String tipoCtaOrigen;
    //private List<BaseResponse.Submov> submov = null;

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getPhoneOrigin() {
        return phoneOrigin;
    }

    public void setPhoneOrigin(String phoneOrigin) {
        this.phoneOrigin = phoneOrigin;
    }

    public String getPhoneDestination() {
        return phoneDestination;
    }

    public void setPhoneDestination(String phoneDestination) {
        this.phoneDestination = phoneDestination;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoDisp() {
        return tipoDisp;
    }

    public void setTipoDisp(String tipoDisp) {
        this.tipoDisp = tipoDisp;
    }

    public String getCtaOrigen() {
        return ctaOrigen;
    }

    public void setCtaOrigen(String ctaOrigen) {
        this.ctaOrigen = ctaOrigen;
    }

    public String getTipoCtaOrigen() {
        return tipoCtaOrigen;
    }

    public void setTipoCtaOrigen(String tipoCtaOrigen) {
        this.tipoCtaOrigen = tipoCtaOrigen;
    }

    /*public List<BaseResponse.Submov> getSubmov() {
        return submov;
    }

    public void setSubmov(List<BaseResponse.Submov> submov) {
        this.submov = submov;
    }*/

}