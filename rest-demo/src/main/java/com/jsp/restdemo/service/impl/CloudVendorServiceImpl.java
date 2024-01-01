package com.jsp.restdemo.service.impl;

import com.jsp.restdemo.exception.CloudVendorNotFoundException;
import com.jsp.restdemo.model.CloudVendor;
import com.jsp.restdemo.repository.CloudVendorRepository;
import com.jsp.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {



    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
           throw new CloudVendorNotFoundException("Requested CloudVendor does not exist");

        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }




}
