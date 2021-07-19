package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.dao.RequestDao;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;

    public List<Request> getRequestList(){
        return requestDao.findByStatusEquals("pending");
    }

    public Request updateRequest(Request request){
        System.out.println("-------------------- this is the request id: "+request.getId());
        System.out.println("-------------------- request status: "+request.getStatus());
        request.setStatus(request.getStatus());
        requestDao.deleteById(request.getId());
        return requestDao.save(request);
    }

    public Request add(Request request){
        return requestDao.save(request);
    }
}
