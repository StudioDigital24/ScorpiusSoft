package com.studiodigital24.scorpiusSoft.entities;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;
        @Column(name = "enterprise")
        private String enterprise;
        @Column(name = "role")
        private String role;

        @Column(name = "profile")
        private String profile;

        @Column(name = "password")
        private String password;

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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getEnterprise() {
                return enterprise;
        }

        public void setEnterprise(String enterprise) {
                this.enterprise = enterprise;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public String getProfile() {
                return profile;
        }

        public void setProfile(String profile) {
                this.profile = profile;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}