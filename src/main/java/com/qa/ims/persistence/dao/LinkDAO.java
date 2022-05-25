package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Link;
import com.qa.ims.utils.DBUtils;

public class LinkDAO implements Dao<Link>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	//model
		@Override
		public Link modelFromResultSet(ResultSet resultSet) throws SQLException {
			Long orderId = resultSet.getLong("order_id");
			Long customerId = resultSet.getLong("customer_id");
			return new Link(orderId, customerId);
		}

	@Override
	public int delete(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_details WHERE details_id = ?");) {
			statement.setLong(1, orderId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Link read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderId);
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
	
	//readLatest
		public Link readLatest() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM order ORDER BY order_id DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

	@Override
	public Link create(Link link) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO order_details(order_id, customer_id) VALUES (?, ?)");) {
				statement.setLong(1, link.getOrderId());
				statement.setLong(2, link.getCustomerId());
				statement.executeUpdate();
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}

	@Override
	public Link update(Link link) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET customer_id = ? WHERE order_id = ?");) {
			statement.setLong(1, link.getCustomerId());
			statement.setLong(2, link.getOrderId());
			statement.executeUpdate();
			return read(link.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Link> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");){
			List<Link> links = new ArrayList<>();
			while(resultSet.next()){
				links.add(modelFromResultSet(resultSet));
			}
			return links;
		}catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	
	
	

}
