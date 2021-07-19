package com.spe.mncManagement.services;

import com.spe.mncManagement.bean.Request;

import java.util.List;

public interface RequestService {
    public List<Request> getRequestList();
    public Request updateRequest(Request request);
    public Request add(Request request);
}
