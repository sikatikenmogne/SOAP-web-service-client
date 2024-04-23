package com.clientws;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversion(100));

        System.out.println("===========================");
        Compte cp = proxy.getCompte(1);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());

        List<Compte> comptes = proxy.listComptes();
        comptes.forEach(c -> {
            System.out.println("===========================");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());
        });
    }
}
