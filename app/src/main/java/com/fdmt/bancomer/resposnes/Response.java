package com.fdmt.bancomer.resposnes;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * Response is part of the POJOs to parse the response we would get from the server.
 */
public class Response implements Serializable {

    private String statusUser;
    private List<ListMov> listMov = null;

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public List<ListMov> getListMov() {
        return listMov;
    }

    public void setListMov(List<ListMov> listMov) {
        this.listMov = listMov;
    }
}