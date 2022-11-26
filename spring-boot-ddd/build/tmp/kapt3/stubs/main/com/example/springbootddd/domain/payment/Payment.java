package com.example.springbootddd.domain.payment;

import com.example.springbootddd.domain.customer.Customer;
import com.example.springbootddd.domain.rental.Rental;
import com.example.springbootddd.domain.staff.Staff;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006+"}, d2 = {"Lcom/example/springbootddd/domain/payment/Payment;", "", "()V", "amount", "Ljava/math/BigDecimal;", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "customer", "Lcom/example/springbootddd/domain/customer/Customer;", "getCustomer", "()Lcom/example/springbootddd/domain/customer/Customer;", "setCustomer", "(Lcom/example/springbootddd/domain/customer/Customer;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "paymentDate", "getPaymentDate", "setPaymentDate", "rental", "Lcom/example/springbootddd/domain/rental/Rental;", "getRental", "()Lcom/example/springbootddd/domain/rental/Rental;", "setRental", "(Lcom/example/springbootddd/domain/rental/Rental;)V", "staff", "Lcom/example/springbootddd/domain/staff/Staff;", "getStaff", "()Lcom/example/springbootddd/domain/staff/Staff;", "setStaff", "(Lcom/example/springbootddd/domain/staff/Staff;)V", "spring-boot-ddd"})
@javax.persistence.Table(name = "payment")
@javax.persistence.Entity()
public class Payment {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "payment_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @javax.persistence.Id()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "customer_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.customer.Customer customer;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "staff_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.staff.Staff staff;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "rental_id")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    private com.example.springbootddd.domain.rental.Rental rental;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "amount", nullable = false, precision = 5, scale = 2)
    private java.math.BigDecimal amount;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "payment_date", nullable = false)
    private java.time.Instant paymentDate;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update")
    private java.time.Instant lastUpdate;
    
    public Payment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getId() {
        return null;
    }
    
    public void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.customer.Customer getCustomer() {
        return null;
    }
    
    public void setCustomer(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.customer.Customer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.staff.Staff getStaff() {
        return null;
    }
    
    public void setStaff(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.staff.Staff p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.rental.Rental getRental() {
        return null;
    }
    
    public void setRental(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.rental.Rental p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.math.BigDecimal getAmount() {
        return null;
    }
    
    public void setAmount(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getPaymentDate() {
        return null;
    }
    
    public void setPaymentDate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getLastUpdate() {
        return null;
    }
    
    public void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
}