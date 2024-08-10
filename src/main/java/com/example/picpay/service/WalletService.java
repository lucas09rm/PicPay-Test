package com.example.picpay.service;

import com.example.picpay.controller.dto.CreateWalletDto;
import com.example.picpay.exception.WalletDataAlreadyExistException;
import com.example.picpay.repository.WalletRepository;
import com.example.picpay.entity.Wallet;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto){

        var walletdb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if(walletdb.isPresent()){
            throw new WalletDataAlreadyExistException("CpfCnpj or Email already exist");
        }

        return walletRepository.save(dto.toWallet());
    }
}
