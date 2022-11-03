package com.studiodigital24.scorpiusSoft.entities;

import javax.persistence.*;

@Entity
@Table(name = "enterprises")
public class Enterprise {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "nit")
        private String nit;

        @Column(name = "phone")
        private String phone;

        @Column(name = "address")
        private String address;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getNit() {
                return nit;
        }

        public void setNit(String nit) {
                this.nit = nit;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }
}