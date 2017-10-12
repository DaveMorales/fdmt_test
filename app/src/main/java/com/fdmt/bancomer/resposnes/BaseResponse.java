package com.fdmt.bancomer.resposnes;


import java.io.Serializable;
import java.util.List;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * BaseResponse is planned to be the base of all the possible responses.
 */

public class BaseResponse implements Serializable {

    private Response response;
    private String status;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


/*
    public class Submov implements Serializable{

        private String idMovement;
        private Long dateCreate;
        private Double amount;
        private String status;
        private String tipoDisp;
        private String ctaOrigen;
        private String tipoCtaOrigen;

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

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
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

    }*/

}