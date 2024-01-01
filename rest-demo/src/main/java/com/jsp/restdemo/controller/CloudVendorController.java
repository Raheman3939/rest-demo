package com.jsp.restdemo.controller;

import com.jsp.restdemo.model.CloudVendor;
import com.jsp.restdemo.response.ResponseHandler;
import com.jsp.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

  CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
  public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId")  String vendorId){

    return ResponseHandler.responseBuilder("Requested Vendor details are given here",
            HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId)
            );


// return cloudVendorService.getCloudVendor(vendorId);
    //  return new CloudVendor("c1","vendor1","address1","xxxx");
  }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }


@PostMapping
  public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
       cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created successfully";
  }
@PutMapping
  public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated successfully";
  }
@DeleteMapping("{vendorId}")
  public String deleteCloudVendorDetails(@PathVariable("vendorId")  String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendor deleted successfully";
  }


}
