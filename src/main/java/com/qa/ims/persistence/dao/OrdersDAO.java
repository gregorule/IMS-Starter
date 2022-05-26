package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
	
	//model
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long detailsId = resultSet.getLong("details_id");
		Long orderId = resultSet.getLong("order_id");//Foreign key
		Long itemId = resultSet.getLong("item_id");//Foreign key
		String orderStat = resultSet.getString("order_status");
		int quantity = resultSet.getInt("quantity");
		float cost = resultSet.getFloat("cost");
		return new Orders(detailsId, orderId, itemId, quantity, orderStat, cost);
	}

	//readAll
	@Override
	public List<Orders> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details");){
			List<Orders> orderss = new ArrayList<>();
			while(resultSet.next()){
				orderss.add(modelFromResultSet(resultSet));
			}
			return orderss;
		}catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	//readLatest
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details ORDER BY details_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
		
	//read
	@Override
	public Orders read(Long detailsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_details WHERE details_id = ?");) {
			statement.setLong(1, detailsId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	//create
	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_details(item_id, order_status, quantity, cost) VALUES (?, ?, ?, ?)");) {
			statement.setLong(1, orders.getItemId());
			statement.setString(2, orders.getOrderStatus());
			statement.setInt(3, orders.getQuantity());
			statement.setDouble(4, orders.getCost());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	//update
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_details SET item_id = ?, order_status = ?, quantity = ?, cost = ? WHERE details_id = ?");) {
			statement.setLong(1, orders.getItemId());
			statement.setString(2, orders.getOrderStatus());
			statement.setInt(3, orders.getQuantity());
			statement.setLong(4, orders.getDetailsId());
			statement.executeUpdate();
			return read(orders.getDetailsId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long detailsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_details WHERE details_id = ?");) {
			statement.setLong(1, detailsId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	//To calculate the cost of the order
	public String getCost(Long itemId) {
		ItemDAO itemDAO = new ItemDAO();
		float cost = itemDAO.read(itemId).getPrice();
		return String.valueOf(cost);
	}
	

}
