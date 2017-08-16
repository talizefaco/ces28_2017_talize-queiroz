class	Money implements MoneyInterface	{
	public	Money(int amount,Currency currency)	{
		this._amount = amount;
		this._currency = currency;
	}
	
	public String stringMoney()
	{
		String str;
		str = this.getCurrency().getString() + " " + this.getAmount() + "\n";
		return str;		
	}
	public int convertMoney()
	{
		int valueBRL;
		if (this.getCurrency().getString() == "BRL")
			valueBRL = this.getAmount();
		else
			valueBRL = this.getAmount()*this.getCurrency().getConvertion();
		return valueBRL;
	}
	public MoneyInterface add(Money m) {
		if(m.getCurrency() == this.getCurrency() ) {
			Money money = new Money(this.getAmount() + m.getAmount(), this.getCurrency());
			return	(Money)money;
		}
		
		else {
			MoneyBag moneyBag = new MoneyBag();
			moneyBag.add(m);
			moneyBag.add(this);
			return (MoneyBag) moneyBag;
		}
	}
	
	public int getAmount() { 
		return _amount;
	}

	public void setAmount(int amount) {
		this._amount = amount;
	}
	
	public Currency getCurrency() {
		return _currency;
	}

	public void setCurrency(Currency currency) {
		this._currency = currency;
	}
	
	private int _amount;
	private Currency _currency;
}
