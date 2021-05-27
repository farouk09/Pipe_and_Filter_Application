package application;
public class QueryProcessor extends Filter {
	
    public QueryProcessor(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}

	Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub

		String request;
		String[] requests;
		do {	
			request = _dataINPipe.dataOUT();

			requests = request.split("-");
		
			for(String s : requests) {
				_dataOUTPipe.dataIN(s);
			}
			
		}while(requests[0]!="0");	
			
		
		
	}

}
