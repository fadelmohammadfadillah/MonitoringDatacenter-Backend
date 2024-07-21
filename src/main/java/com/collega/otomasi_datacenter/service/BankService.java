package com.collega.otomasi_datacenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collega.otomasi_datacenter.model.Bank;
import com.collega.otomasi_datacenter.repository.BankRepository;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public String createBank(Bank request){
        try {
            var bank = Bank.builder()
                            .bankName(request.getBankName().toUpperCase())
                            .build();
            bankRepository.save(bank);
            return "Bank baru berhasil ditambahkan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Bank baru gagal ditambahkan!");
        }
    }

    public String updateBank(Integer id, Bank request){
        try {
            Bank bank = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank tidak ditemukan!"));
            bank.setBankName(request.getBankName().toUpperCase());
            bankRepository.save(bank);
            return "Data perubahan bank berhasil disimpan!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Perubahan data bank gagal!");
        }
    }

    public String deleteBank(Integer id){
        try {
            Bank bank = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank tidak ditemukan!"));
            bankRepository.delete(bank);
            return "Data bank berhasil di hapus!";
        } catch (RuntimeException e) {
            throw new RuntimeException("Data bank tidak dapat ditemukan");
        }
    }

    public List<Bank> getAllBanks(){
        List<Bank> results = bankRepository.findAll();
        return results;
    }
}
