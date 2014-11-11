package com.ami.en;

import com.google.common.base.Objects;



public enum BankAccountType {

	  /**
   * 1 借记卡卡
   */
  BANK_CARD("BNK1","1"),

  /**
   * 2 信用卡(贷记卡)
   */
  BANK_CREDIT("BNK2","2"),

  /**
   * 4 存折
   */
  BANK_BANKBOOK("BNK3","4"),

  /**
   * 8 公司账户
   */
  BANK_COMPANY_ACCOUNT("BNK4","8");
  
 
  private final String peAccType;

  /**
   * 银行网关账户(卡)类型
   */

  private final String bankAccType;
  
  private BankAccountType(String peAccType,String bankAccType) {
      this.peAccType = peAccType;
      this.bankAccType = bankAccType;
  }
  
  
  public static BankAccountType explain(String peAccType) {
      for (BankAccountType bankAccountType : BankAccountType.values()) {
          if (Objects.equal(peAccType, bankAccountType.peAccType)) {
              return bankAccountType;
          }
      }
      return null;
  }
  
  public static String explainType(String peAccType) {
      for (BankAccountType bankAccountType : BankAccountType.values()) {
          if (Objects.equal(peAccType, bankAccountType.peAccType)) {
              return bankAccountType.bankAccType;
          }
      }
      return null;
  }
}