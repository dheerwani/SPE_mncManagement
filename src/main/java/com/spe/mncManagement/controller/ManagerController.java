package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.services.ProjectService;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/requestList")
    public List<Request> getRequestList(){
        return requestService.getRequestList();
    }

    @PostMapping(path = "/updateRequest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Request updateRequest(@RequestBody Request request){
        return requestService.updateRequest(request);
    }


}
