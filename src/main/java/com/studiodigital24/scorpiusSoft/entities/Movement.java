package com.studiodigital24.scorpiusSoft.entities;

import javax.persistence.*;

@Entity
@Table(name = "movements")
public class Movement {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "concept")
        private String concept;

        @Column(name = "amount")
        private String amount;

        @Column(name = "employee")
        private String employee;

        @Column(name = "enterprise")
        private String enterprise;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getConcept() {
                return concept;
        }

        public void setConcept(String concept) {
                this.concept = concept;
        }

        public String getAmount() {
                return amount;
        }

        public void setAmount(String amount) {
                this.amount = amount;
        }

        public String getEmployee() {
                return employee;
        }

        public void setEmployee(String employee) {
                this.employee = employee;
        }

        public String getEnterprise() {
                return enterprise;
        }

        public void setEnterprise(String enterprise) {
                this.enterprise = enterprise;
        }
}