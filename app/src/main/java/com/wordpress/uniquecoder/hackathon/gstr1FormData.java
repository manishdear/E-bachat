package com.wordpress.uniquecoder.hackathon;

public class gstr1FormData {

    String I4Invoice, I4Taxable, I4Liability;
    String I5Invoice, I5Taxable, I5Liability;
    String RegisteredTaxable, RegisteredLiability;
    String UnregisteredTaxable, UnregisteredLiability;
    String ExportInvoice, ExportTaxable, ExportLiability;
    String OtherTaxable, OtherLiability;
    String SuppliesNill, SuppliesExempted, SuppliesNon_gst;
    String AdvancesReceived, AdvancesLiability;
    String AdvanceAdjusted, AdjustementLiability;
    String hsnInvoice, hsnTaxable, hsnLiability;
    String DocumentTotal, DocumentCencelled, DocumentIssued;

    public gstr1FormData(){

    }

    public gstr1FormData(String i4Invoice, String i4Taxable, String i4Liability,
                         String i5Invoice, String i5Taxable, String i5Liability,
                         String registeredTaxable, String registeredLiability,
                         String unregisteredTaxable, String unregisteredLiability,
                         String exportInvoice, String exportTaxable, String exportLiability,
                         String otherTaxable, String otherLiability, String suppliesNill,
                         String suppliesExempted, String suppliesNon_gst, String advancesReceived,
                         String advancesLiability, String advanceAdjusted, String adjustementLiability,
                         String hsnInvoice, String hsnTaxable, String hsnLiability,
                         String documentTotal, String documentCencelled, String documentIssued) {
        I4Invoice = i4Invoice;
        I4Taxable = i4Taxable;
        I4Liability = i4Liability;
        I5Invoice = i5Invoice;
        I5Taxable = i5Taxable;
        I5Liability = i5Liability;
        RegisteredTaxable = registeredTaxable;
        RegisteredLiability = registeredLiability;
        UnregisteredTaxable = unregisteredTaxable;
        UnregisteredLiability = unregisteredLiability;
        ExportInvoice = exportInvoice;
        ExportTaxable = exportTaxable;
        ExportLiability = exportLiability;
        OtherTaxable = otherTaxable;
        OtherLiability = otherLiability;
        SuppliesNill = suppliesNill;
        SuppliesExempted = suppliesExempted;
        SuppliesNon_gst = suppliesNon_gst;
        AdvancesReceived = advancesReceived;
        AdvancesLiability = advancesLiability;
        AdvanceAdjusted = advanceAdjusted;
        AdjustementLiability = adjustementLiability;
        this.hsnInvoice = hsnInvoice;
        this.hsnTaxable = hsnTaxable;
        this.hsnLiability = hsnLiability;
        DocumentTotal = documentTotal;
        DocumentCencelled = documentCencelled;
        DocumentIssued = documentIssued;
    }

    public String getI4Invoice() {
        return I4Invoice;
    }

    public void setI4Invoice(String i4Invoice) {
        I4Invoice = i4Invoice;
    }

    public String getI4Taxable() {
        return I4Taxable;
    }

    public void setI4Taxable(String i4Taxable) {
        I4Taxable = i4Taxable;
    }

    public String getI4Liability() {
        return I4Liability;
    }

    public void setI4Liability(String i4Liability) {
        I4Liability = i4Liability;
    }

    public String getI5Invoice() {
        return I5Invoice;
    }

    public void setI5Invoice(String i5Invoice) {
        I5Invoice = i5Invoice;
    }

    public String getI5Taxable() {
        return I5Taxable;
    }

    public void setI5Taxable(String i5Taxable) {
        I5Taxable = i5Taxable;
    }

    public String getI5Liability() {
        return I5Liability;
    }

    public void setI5Liability(String i5Liability) {
        I5Liability = i5Liability;
    }

    public String getRegisteredTaxable() {
        return RegisteredTaxable;
    }

    public void setRegisteredTaxable(String registeredTaxable) {
        RegisteredTaxable = registeredTaxable;
    }

    public String getRegisteredLiability() {
        return RegisteredLiability;
    }

    public void setRegisteredLiability(String registeredLiability) {
        RegisteredLiability = registeredLiability;
    }

    public String getUnregisteredTaxable() {
        return UnregisteredTaxable;
    }

    public void setUnregisteredTaxable(String unregisteredTaxable) {
        UnregisteredTaxable = unregisteredTaxable;
    }

    public String getUnregisteredLiability() {
        return UnregisteredLiability;
    }

    public void setUnregisteredLiability(String unregisteredLiability) {
        UnregisteredLiability = unregisteredLiability;
    }

    public String getExportInvoice() {
        return ExportInvoice;
    }

    public void setExportInvoice(String exportInvoice) {
        ExportInvoice = exportInvoice;
    }

    public String getExportTaxable() {
        return ExportTaxable;
    }

    public void setExportTaxable(String exportTaxable) {
        ExportTaxable = exportTaxable;
    }

    public String getExportLiability() {
        return ExportLiability;
    }

    public void setExportLiability(String exportLiability) {
        ExportLiability = exportLiability;
    }

    public String getOtherTaxable() {
        return OtherTaxable;
    }

    public void setOtherTaxable(String otherTaxable) {
        OtherTaxable = otherTaxable;
    }

    public String getOtherLiability() {
        return OtherLiability;
    }

    public void setOtherLiability(String otherLiability) {
        OtherLiability = otherLiability;
    }

    public String getSuppliesNill() {
        return SuppliesNill;
    }

    public void setSuppliesNill(String suppliesNill) {
        SuppliesNill = suppliesNill;
    }

    public String getSuppliesExempted() {
        return SuppliesExempted;
    }

    public void setSuppliesExempted(String suppliesExempted) {
        SuppliesExempted = suppliesExempted;
    }

    public String getSuppliesNon_gst() {
        return SuppliesNon_gst;
    }

    public void setSuppliesNon_gst(String suppliesNon_gst) {
        SuppliesNon_gst = suppliesNon_gst;
    }

    public String getAdvancesReceived() {
        return AdvancesReceived;
    }

    public void setAdvancesReceived(String advancesReceived) {
        AdvancesReceived = advancesReceived;
    }

    public String getAdvancesLiability() {
        return AdvancesLiability;
    }

    public void setAdvancesLiability(String advancesLiability) {
        AdvancesLiability = advancesLiability;
    }

    public String getAdvanceAdjusted() {
        return AdvanceAdjusted;
    }

    public void setAdvanceAdjusted(String advanceAdjusted) {
        AdvanceAdjusted = advanceAdjusted;
    }

    public String getAdjustementLiability() {
        return AdjustementLiability;
    }

    public void setAdjustementLiability(String adjustementLiability) {
        AdjustementLiability = adjustementLiability;
    }

    public String getHsnInvoice() {
        return hsnInvoice;
    }

    public void setHsnInvoice(String hsnInvoice) {
        this.hsnInvoice = hsnInvoice;
    }

    public String getHsnTaxable() {
        return hsnTaxable;
    }

    public void setHsnTaxable(String hsnTaxable) {
        this.hsnTaxable = hsnTaxable;
    }

    public String getHsnLiability() {
        return hsnLiability;
    }

    public void setHsnLiability(String hsnLiability) {
        this.hsnLiability = hsnLiability;
    }

    public String getDocumentTotal() {
        return DocumentTotal;
    }

    public void setDocumentTotal(String documentTotal) {
        DocumentTotal = documentTotal;
    }

    public String getDocumentCencelled() {
        return DocumentCencelled;
    }

    public void setDocumentCencelled(String documentCencelled) {
        DocumentCencelled = documentCencelled;
    }

    public String getDocumentIssued() {
        return DocumentIssued;
    }

    public void setDocumentIssued(String documentIssued) {
        DocumentIssued = documentIssued;
    }
}
