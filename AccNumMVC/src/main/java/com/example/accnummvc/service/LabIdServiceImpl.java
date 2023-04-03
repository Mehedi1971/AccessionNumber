package com.example.accnummvc.service;

//import com.example.accnumdatabase.entity.LabId;
//import com.example.accnumdatabase.repository.LabIdRepository;
import com.example.accnummvc.entity.LabId;
import com.example.accnummvc.repository.LabIdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class LabIdServiceImpl implements LabIdService{
    private final LabIdRepository labIdRepository;


    public LabIdServiceImpl(LabIdRepository labIdRepository) {
        this.labIdRepository = labIdRepository;
    }

    public String accnum(LabId labId){

        String lastId = labIdRepository.findAllUsers();
        System.out.println(lastId);
        int initialValue=10000;
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dt= localDate.format(localDate1);

        System.out.println(lastId.substring(0,lastId.indexOf("-")));
        System.out.println(lastId.substring(lastId.indexOf("-")));


        if (!lastId.isEmpty() && lastId.substring(0,lastId.indexOf("-")).equals(dt)){
            initialValue = Integer.parseInt(lastId.substring(lastId.indexOf("-")+1));
        }


        initialValue++;
        String acc=dt+"-"+ initialValue;
        System.out.println(dt+"-"+ initialValue);
        labId.setValue(dt+"-"+ initialValue);

        return acc;
    }



    @Override
    public void saveAcc(LabId labId) {
        labId.setValue(accnum(labId));
        this.labIdRepository.save(labId);
    }
}
