package ebookbackend.dao;

import java.util.List;

import ebookbackend.dto.Favourite;
import ebookbackend.dto.FavouriteLine;
import ebookbackend.dto.OrderDetail;

public interface FavouriteLineDAO {

	public List<FavouriteLine> list(int favouriteId);
	public FavouriteLine get(int id);	
	public boolean add(FavouriteLine favouriteLine);
	public boolean update(FavouriteLine favouriteLine);
	public boolean remove(FavouriteLine favouriteLine);
	
	// fetch the FavouriteLine based on favouriteId and productId
	public FavouriteLine getByFavouriteAndProduct(int favouriteId, int productId);		
		
	// updating the favourite
	boolean updateFavourite(Favourite favourite);
	
	// list of available favouriteLine
	public List<FavouriteLine> listAvailable(int favouriteId);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);

	
}
