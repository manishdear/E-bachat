package com.wordpress.uniquecoder.hackathon;

public class gstr4FormData {

    String taxLiability, taxPaidthroughCash;
    String debitEntriesInCashIntegratedTax, debitEntriesInCashCentralTax, debitEntriesInCashStateTax, debitEntriesInCashCess;
    String refundClaimTotalTax, refundIntrestClaim, refundLateFeeClaim;

    public gstr4FormData(){

    }

    public gstr4FormData(String taxLiability, String taxPaidthroughCash,
                         String debitEntriesInCashIntegratedTax,
                         String debitEntriesInCashCentralTax,
                         String debitEntriesInCashStateTax, String debitEntriesInCashCess,
                         String refundClaimTotalTax, String refundIntrestClaim,
                         String refundLateFeeClaim) {
        this.taxLiability = taxLiability;
        this.taxPaidthroughCash = taxPaidthroughCash;
        this.debitEntriesInCashIntegratedTax = debitEntriesInCashIntegratedTax;
        this.debitEntriesInCashCentralTax = debitEntriesInCashCentralTax;
        this.debitEntriesInCashStateTax = debitEntriesInCashStateTax;
        this.debitEntriesInCashCess = debitEntriesInCashCess;
        this.refundClaimTotalTax = refundClaimTotalTax;
        this.refundIntrestClaim = refundIntrestClaim;
        this.refundLateFeeClaim = refundLateFeeClaim;
    }

    public String getTaxLiability() {
        return taxLiability;
    }

    public void setTaxLiability(String taxLiability) {
        this.taxLiability = taxLiability;
    }

    public String getTaxPaidthroughCash() {
        return taxPaidthroughCash;
    }

    public void setTaxPaidthroughCash(String taxPaidthroughCash) {
        this.taxPaidthroughCash = taxPaidthroughCash;
    }

    public String getDebitEntriesInCashIntegratedTax() {
        return debitEntriesInCashIntegratedTax;
    }

    public void setDebitEntriesInCashIntegratedTax(String debitEntriesInCashIntegratedTax) {
        this.debitEntriesInCashIntegratedTax = debitEntriesInCashIntegratedTax;
    }

    public String getDebitEntriesInCashCentralTax() {
        return debitEntriesInCashCentralTax;
    }

    public void setDebitEntriesInCashCentralTax(String debitEntriesInCashCentralTax) {
        this.debitEntriesInCashCentralTax = debitEntriesInCashCentralTax;
    }

    public String getDebitEntriesInCashStateTax() {
        return debitEntriesInCashStateTax;
    }

    public void setDebitEntriesInCashStateTax(String debitEntriesInCashStateTax) {
        this.debitEntriesInCashStateTax = debitEntriesInCashStateTax;
    }

    public String getDebitEntriesInCashCess() {
        return debitEntriesInCashCess;
    }

    public void setDebitEntriesInCashCess(String debitEntriesInCashCess) {
        this.debitEntriesInCashCess = debitEntriesInCashCess;
    }

    public String getRefundClaimTotalTax() {
        return refundClaimTotalTax;
    }

    public void setRefundClaimTotalTax(String refundClaimTotalTax) {
        this.refundClaimTotalTax = refundClaimTotalTax;
    }

    public String getRefundIntrestClaim() {
        return refundIntrestClaim;
    }

    public void setRefundIntrestClaim(String refundIntrestClaim) {
        this.refundIntrestClaim = refundIntrestClaim;
    }

    public String getRefundLateFeeClaim() {
        return refundLateFeeClaim;
    }

    public void setRefundLateFeeClaim(String refundLateFeeClaim) {
        this.refundLateFeeClaim = refundLateFeeClaim;
    }
}
