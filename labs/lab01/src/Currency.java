class	Currency	{
	public	Currency(String currency, int convertion)	{
		this._currency = currency;
		this._convertion = convertion;
	}
	
	public String getString() {
		return _currency;
	}
	public int getConvertion() {
		return _convertion;
	}
	private String _currency;
	private int _convertion;
}

