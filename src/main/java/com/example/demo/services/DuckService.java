package com.example.demo.services;

import com.example.demo.DTOs.DuckRecordDto;
import com.example.demo.entities.ResultObj;
import com.example.demo.models.DuckModel;
import com.example.demo.repositories.DuckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuckService {

    @Autowired
    DuckRepository duckRepository;

    public ResultObj registerDuck(DuckRecordDto duckRecordDto) {
        DuckModel duckModel = new DuckModel();
        ResultObj resultObj = new ResultObj();

        BeanUtils.copyProperties(duckRecordDto, duckModel);
        Optional<DuckModel> duckParentO = duckRepository.findById(duckRecordDto.parentId());

        if (duckParentO.isEmpty()) {
            resultObj.setStatus("Duck parent not found");
            resultObj.setObj(duckRecordDto);
            return resultObj;
        }

        resultObj.setStatus("Duck saved");
        resultObj.setObj(duckRepository.save(duckModel));

        return resultObj;
    }

    public List<DuckModel> getAllDucks() {
        return duckRepository.findAll();
    }

    public ResultObj getDuckById(Long id) {
        ResultObj resultObj = new ResultObj();

        Optional<DuckModel> duckO = duckRepository.findById(id);

        if (duckO.isEmpty()) {
            resultObj.setStatus("Duck not found");
            return resultObj;
        }

        resultObj.setStatus("Duck saved");
        resultObj.setObj(duckO);

        return resultObj;
    }
}