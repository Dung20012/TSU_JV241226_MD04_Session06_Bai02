package com.data.session_06.model.dao;

import com.data.session_06.model.entity.Movie;
import com.data.session_06.model.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public List<Movie> findAll() {
        List<Movie> list = new ArrayList<>();
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "select * from movies";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Movie movie = new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Movie findById(Long id) {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "select * from movies where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void  insert(Movie movie) {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "insert into movies(title, director, genre, description, duration, language) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setString(3, movie.getGenre());
            ps.setString(4, movie.getDescription());
            ps.setInt(5, movie.getDuration());
            ps.setString(6, movie.getLanguage());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  update(Movie movie) {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "update movies set  title=?, director=?, genre=?, description=?, duration=?, language=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setString(3, movie.getGenre());
            ps.setString(4, movie.getDescription());
            ps.setInt(5, movie.getDuration());
            ps.setString(6, movie.getLanguage());
            ps.setLong(7, movie.getId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void  delete(Long id) {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "delete from movies where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
