package com.client.BookShopSystem.EndPointUtility;

public interface EndPoint {
	public interface IEndPoint{
		public String addBook="/Books";
		public String getBook="/Books/{BookId}";
		public String updateBook="/Book/{BookId}";
		public String deletBook="/Book/{BookId}";
		public String patchupdate="/Book/{BookI}?page=10";
				
		
		
		
	}

}
