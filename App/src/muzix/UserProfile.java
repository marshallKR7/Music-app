/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muzix;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Naman
 */
public class UserProfile extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    private JFrame prevView;
    private User user;
    private ArrayList<Song> songs;
    private DefaultTableModel model;
    private TableRowSorter<TableModel> sorter;
    AudioInputStream audioInputStream;
    Long currentFrame; 
    Clip clip; 
    String status;
    JTable prevPlaying;
    int lastRow;
    int lastCol;
    
    public UserProfile(JFrame prevView, User user) throws IOException {
        this.songs = this.getSongs();
        this.user = user;
        this.prevView = prevView;
        prevPlaying = null;
        initComponents();
        this.setTitle("Profile");
        this.setSize(prevView.getSize());
        this.setLocation(prevView.getLocation());
        welcomeText.setText("Welcome, "+user.getName());
        welcomeText.setBackground(new Color(0xF7F7F7));
        
        header.setBackground(new Color(0xF7F7F7));
        
        searchButton.setBorderPainted(false);
        searchButton.setBorder(new RoundedBorder(8)); //10 is the radius
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);
        searchButton.setBackground(new Color(0x90CCF4));
        
        viewArtists.setBorderPainted(false);
        viewArtists.setBorder(new RoundedBorder(8)); //10 is the radius
        viewArtists.setFocusPainted(false);
        viewArtists.setOpaque(false);
        viewArtists.setBackground(new Color(0x90CCF4));
        
        viewAlbums.setBorderPainted(false);
        viewAlbums.setBorder(new RoundedBorder(8)); //10 is the radius
        viewAlbums.setFocusPainted(false);
        viewAlbums.setOpaque(false);
        viewAlbums.setBackground(new Color(0x90CCF4));
        
        viewSongs.setBorderPainted(false);
        viewSongs.setBorder(new RoundedBorder(8)); //10 is the radius
        viewSongs.setFocusPainted(false);
        viewSongs.setOpaque(false);
        viewSongs.setBackground(new Color(0x90CCF4));
        
        topNSongs.setBorderPainted(false);
        topNSongs.setBorder(new RoundedBorder(8)); //10 is the radius
        topNSongs.setFocusPainted(false);
        topNSongs.setOpaque(false);
        topNSongs.setBackground(new Color(0x90CCF4));
        
        viewHistory.setBorderPainted(false);
        viewHistory.setBorder(new RoundedBorder(8)); //10 is the radius
        viewHistory.setFocusPainted(false);
        viewHistory.setOpaque(false);
        viewHistory.setBackground(new Color(0x90CCF4));
        
        logout.setBorderPainted(false);
        logout.setBorder(new RoundedBorder(8)); //10 is the radius
        logout.setFocusPainted(false);
        logout.setOpaque(false);
        logout.setBackground(new Color(0x90CCF4));
        
        changePasswordButton.setBorderPainted(false);
        changePasswordButton.setBorder(new RoundedBorder(8)); //10 is the radius
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setOpaque(false);
        changePasswordButton.setBackground(new Color(0x90CCF4));
        
        this.createSongTable(songs);
        this.getContentPane().setBackground(new Color(0xF7F7F7));
        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        changePasswordButton = new javax.swing.JButton();
        welcomeText = new java.awt.Label();
        header = new java.awt.Label();
        logout = new javax.swing.JButton();
        viewAlbums = new javax.swing.JButton();
        viewArtists = new javax.swing.JButton();
        viewSongs = new javax.swing.JButton();
        topNSongs = new javax.swing.JButton();
        viewHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchText.setText("Search text");
        searchText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextMouseClicked(evt);
            }
        });
        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });

        panel.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        changePasswordButton.setText("Update Details");
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        welcomeText.setText("label1");

        header.setName(""); // NOI18N
        header.setText("History");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        viewAlbums.setText("View By Albums");
        viewAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAlbumsActionPerformed(evt);
            }
        });

        viewArtists.setText("View By Artists");
        viewArtists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewArtistsActionPerformed(evt);
            }
        });

        viewSongs.setText("View All Songs");
        viewSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSongsActionPerformed(evt);
            }
        });

        topNSongs.setText("By Popularity");
        topNSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topNSongsActionPerformed(evt);
            }
        });

        viewHistory.setText("History");
        viewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(welcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewArtists, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewAlbums, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewSongs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topNSongs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewHistory)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changePasswordButton)
                        .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewAlbums)
                            .addComponent(viewArtists)
                            .addComponent(viewSongs)
                            .addComponent(topNSongs)
                            .addComponent(viewHistory))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try {
            clip.stop();
        }
        catch(Exception e) {

        }
        String searchString = searchText.getText().trim();
        if (searchString.length() == 0) {
            sorter.setRowFilter(null);
        }
        else {
            sorter.setRowFilter(RowFilter.regexFilter(searchString));
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            searchText.setText("");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            // TODO add your handling code here:
            JTextField name = new JTextField();
            name.setText(user.getName());
            JTextField oldPassword = new JPasswordField();
            JTextField password = new JPasswordField();
            
            Object[] input = {
                "Name : ", name,
                "Old Password :", oldPassword,
                "New Password :", password,
            };
            int option = JOptionPane.showConfirmDialog(this, input, "Enter Song details", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                    Connection con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");

                    String query = "select password, name from userDetails where username=?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, user.getUsername());

                    ResultSet rs = ps.executeQuery();
                    //ResultSet rs = stmt.executeQuery("select password, name from adminDetails where username="+username.getText().trim().toLowerCase());

                    if(!rs.next()) {
                        System.out.println("Fail - "+password.getText()+" "+oldPassword.getText()+" " +user.getUsername());
                        JOptionPane.showMessageDialog(this, "Error!\n");
                        return;
                    }
                    else {
                        if(rs.getString(1).equalsIgnoreCase(oldPassword.getText()) && !(password.getText().equals(oldPassword))) {
                            ps = con.prepareStatement("update userDetails set password=? where username=?");
                            ps.setString(1, password.getText().trim());
                            ps.setString(2, user.getUsername().toLowerCase());
                            ps.execute();
                        }
                        if(rs.getString(1).equalsIgnoreCase(oldPassword.getText()) && !(name.getText().equals(user.getName()))) {
                            ps = con.prepareStatement("update userDetails set name=? where username=?");
                            ps.setString(1, password.getText().trim());
                            ps.setString(2, user.getUsername().toLowerCase());
                            ps.execute();
                        }
                        if(!rs.getString(1).equalsIgnoreCase(oldPassword.getText())) {
                            JOptionPane.showMessageDialog(this, "Old password did not match!\n");
                        }
                    }
                    
                    con.close();  
                    JOptionPane.showMessageDialog(this, "Success!\n");
                } 

            }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!\n"+e.getMessage());
        }
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        try {
            clip.stop();
        }
        catch(Exception e) {
            
        }
        UserLogin ob = new UserLogin(this);
        ob.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutActionPerformed

    private void viewAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAlbumsActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            try {
                clip.stop();
            }
            catch(Exception e) {

            }
            
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
            
            //step3 create the statement object
            Statement stmt=con.createStatement();
            
            //step4 execute query
            ResultSet rs = stmt.executeQuery("select * from album");
            ArrayList<String> albumList = new ArrayList<String>();
            HashMap<String, String> albumID = new HashMap<>();
            
            while(rs.next()) {
                albumList.add((rs.getString(2)));
                albumID.put(rs.getString(2), rs.getString(1));
            }
            //step5 close the connection object
            con.close();
            
            
            // TODO add your handling code here:
            JComboBox<String> albums = new JComboBox<String>(albumList.toArray(new String[0]));
            
            
            Object[] input = {
                "Albums :", albums,
            };
            int option = JOptionPane.showConfirmDialog(this, input, "Select Album", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                
                 try{  
                     songs = new ArrayList<>();
                    
                    Class.forName("oracle.jdbc.driver.OracleDriver");  
                    con = DriverManager.getConnection(
                             "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
                    
                    
                    PreparedStatement ps = con.prepareStatement ("select * from song where album_id=?");
                    ps.setString(1, albumID.get( albums.getSelectedItem().toString()));  
                    rs = ps.executeQuery();
                    while(rs.next()){

                        String artistsString = "";
                        PreparedStatement ps1=con.prepareStatement("select artist_id from song_artist where song_id=?");
                        ps1.setString(1, ""+rs.getString(1));
                        ResultSet rs1=ps1.executeQuery();
                        if(rs1.next()) {
                            PreparedStatement ps2=con.prepareStatement("select name from artist where id=?");
                            ps2.setString(1, rs1.getString(1));
                            ResultSet rs2=ps2.executeQuery();
                            rs2.next();
                            artistsString = rs2.getString(1);
                        }
                        while(rs1.next()) {
                            PreparedStatement ps2=con.prepareStatement("select name from artist where id=?");
                            ps2.setString(1, rs1.getString(1));
                            ResultSet rs2=ps2.executeQuery();
                            rs2.next();
                            artistsString  = artistsString + ", " + rs2.getString(1);
                        }
                        songs.add(new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), artistsString, Integer.parseInt(rs.getString(5))));
                        ps1.close();
                    }


                } catch (SQLException ex) {
                    Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.createSongTable(songs);
                con.close();  

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!\n"+e.getMessage());
        }
    }//GEN-LAST:event_viewAlbumsActionPerformed

    private void viewArtistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewArtistsActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            try {
                clip.stop();
            }
            catch(Exception e) {

            }
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
            
            //step3 create the statement object
            Statement stmt=con.createStatement();
            
            //step4 execute query
            ResultSet rs = stmt.executeQuery("select * from artist");
            ArrayList<String> artistList = new ArrayList<String>();
            HashMap<String, String> artistID = new HashMap<>();
            
            while(rs.next()) {
                artistList.add((rs.getString(2)));
                artistID.put(rs.getString(2), rs.getString(1));
            }
            //step5 close the connection object
            con.close();
            
            
            // TODO add your handling code here:
            JComboBox<String> artists = new JComboBox<String>(artistList.toArray(new String[0]));
            
            
            Object[] input = {
                "Artist :", artists,
            };
            int option = JOptionPane.showConfirmDialog(this, input, "Select Artist", JOptionPane.OK_CANCEL_OPTION);
            if(option == JOptionPane.OK_OPTION) {
                
                 try{  
                     songs = new ArrayList<>();
                    
                    Class.forName("oracle.jdbc.driver.OracleDriver");  
                    con = DriverManager.getConnection(
                             "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
                     
                    PreparedStatement ps = con.prepareStatement ("select song_id from song_artist where artist_id=?");
                    ps.setString(1, artistID.get( artists.getSelectedItem().toString()));  
                    ResultSet rs0 = ps.executeQuery();
                   
                    
                    while(rs0.next()) {
                        ps = con.prepareStatement ("select * from song where id=?");
                        ps.setString(1, rs0.getString(1));  
                        rs = ps.executeQuery();
                        while(rs.next()){
                        
                            String artistsString = "";
                            PreparedStatement ps1=con.prepareStatement("select artist_id from song_artist where song_id=?");
                            ps1.setString(1, ""+rs.getString(1));
                            ResultSet rs1=ps1.executeQuery();
                            if(rs1.next()) {
                                PreparedStatement ps2=con.prepareStatement("select name from artist where id=?");
                                ps2.setString(1, rs1.getString(1));
                                ResultSet rs2=ps2.executeQuery();
                                rs2.next();
                                artistsString = rs2.getString(1);
                            }
                            while(rs1.next()) {
                                PreparedStatement ps2=con.prepareStatement("select name from artist where id=?");
                                ps2.setString(1, rs1.getString(1));
                                ResultSet rs2=ps2.executeQuery();
                                rs2.next();
                                artistsString  = artistsString + ", " + rs2.getString(1);
                            }
                            songs.add(new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), artistsString, Integer.parseInt(rs.getString(5))));
                            ps1.close();
                        }
                        
                        
                    }
                    this.createSongTable(songs);
                    con.close();  

                } catch (Exception e) {e.printStackTrace();}  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!\n"+e.getMessage());
        }
        
    }//GEN-LAST:event_viewArtistsActionPerformed

    private void viewSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSongsActionPerformed
        try {
            // TODO add your handling code here:
            
               
            try {
                clip.stop();
            }
            catch(Exception e) {

            }
            songs = this.getSongs();
            this.createSongTable(songs);
            header.setText("All Songs");
        } catch (IOException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_viewSongsActionPerformed

    private void topNSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topNSongsActionPerformed
        try {
            // TODO add your handling code here:
               
            try {
                clip.stop();
            }
            catch(Exception e) {

            }
            songs = this.getSongs();
            Collections.sort(songs);
            this.createSongTable(songs);
            header.setText("By Popularity");
        } catch (IOException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_topNSongsActionPerformed

    private void viewHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewHistoryActionPerformed
        try {
            // TODO add your handling code here:
               
            try {
                clip.stop();
            }
            catch(Exception e) {

            }
            songs = this.getHistory();
            this.createSongTable(songs);
            header.setText("History");
        } catch (IOException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_viewHistoryActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
        String searchString = searchText.getText().trim();
        if (searchString.length() == 0) {
            sorter.setRowFilter(null);
        }
        else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchString)); //Ingnore case
        }
    }//GEN-LAST:event_searchTextActionPerformed

    private void searchTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextMouseClicked
        // TODO add your handling code here:
        searchText.setText("");
    }//GEN-LAST:event_searchTextMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordButton;
    private java.awt.Label header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JPanel panel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JButton topNSongs;
    private javax.swing.JButton viewAlbums;
    private javax.swing.JButton viewArtists;
    private javax.swing.JButton viewHistory;
    private javax.swing.JButton viewSongs;
    private java.awt.Label welcomeText;
    // End of variables declaration//GEN-END:variables


    private ArrayList<Song> getHistory() throws IOException {
        ArrayList<Song> songList = new ArrayList<>();
        try {                        
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
            
            //step3 create the statement object
            Statement stmt=con.createStatement();
            
            //step4 execute query
            PreparedStatement ps0 = con.prepareStatement("select * from history where user_id=? order by last_played");
            ps0.setString(1, user.getUsername());
            ResultSet rs=ps0.executeQuery();
            while(rs.next()) {
                String song_id = rs.getString(2);
                for(Song s:songs) {
                    if(s.getId().equalsIgnoreCase(song_id)) {
                        songList.add(s);
                        break;
                    }
                }
                
            }
            //step5 close the connection object
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return songList;
    }
    
    private ArrayList<Song> getSongs() throws IOException {
        ArrayList<Song> songs = new ArrayList<>();
        try {                        
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");
            
            //step3 create the statement object
            Statement stmt=con.createStatement();
            
            //step4 execute query
            ResultSet rs=stmt.executeQuery("select * from song");
            while(rs.next()) {
                String artists = "";
                PreparedStatement ps=con.prepareStatement("select artist_id from song_artist where song_id=?");
                ps.setString(1, ""+rs.getString(1));
                ResultSet rs1=ps.executeQuery();
                if(rs1.next()) {
                    PreparedStatement ps1=con.prepareStatement("select name from artist where id=?");
                    ps1.setString(1, rs1.getString(1));
                    ResultSet rs2=ps1.executeQuery();
                    rs2.next();
                    artists = rs2.getString(1);
                }
                while(rs1.next()) {
                    PreparedStatement ps1=con.prepareStatement("select name from artist where id=?");
                    ps1.setString(1, rs1.getString(1));
                    ResultSet rs2=ps1.executeQuery();
                    rs2.next();
                    artists = artists + ", " + rs2.getString(1);
                }
                System.out.println("DIDI "+Integer.parseInt(rs.getString(5)));
                songs.add(new Song(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), artists, Integer.parseInt(rs.getString(5))));
            }
            //step5 close the connection object
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return songs;
    }

    private void createSongTable(ArrayList<Song> songs) {
        String col[] = {"Song Name", "Album", "Genre", "Artists", ""};
        
        DefaultTableModel model = new DefaultTableModel(col, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        for(Song song: songs) {
            model.addRow(song.getRow());
            System.out.println(song.getRow()[1]);
        }
        
        JTable myTable = new JTable(model);
        
        myTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                int col = target.getSelectedColumn();
                if(col==4) {
                    if(target.getValueAt(row, col)=="Stop") {
                        clip.stop();
                        target.setValueAt("Play", row, col);
                        songs.get(row).toggleStatus();
                    }
                    else {
                        try{
                            try {
                                clip.stop();
                                prevPlaying.setValueAt("Play", lastRow, lastCol);
                                songs.get(lastRow).toggleStatus();
                            }
                            catch(NullPointerException ne){}
                            Class.forName("oracle.jdbc.driver.OracleDriver");

                            Connection con=DriverManager.getConnection(
                                                "jdbc:oracle:thin:@localhost:1521:newdatabase","system","not12345");

                            PreparedStatement ps=con.prepareStatement("select * from song where id = ?"); 
                            ps.setString(1, songs.get(row).getId());
                            ResultSet rs=ps.executeQuery();  
                            String filename = "C:\\Users\\lenovo\\Desktop\\temp.wav";

                            File file = new File(filename);
                            FileOutputStream fos = new FileOutputStream(file);

                            System.out.println("Writing BLOB to file " + file.getAbsolutePath());
                            while (rs.next()) {
                                InputStream input = rs.getBinaryStream(7);
                                byte[] buffer = new byte[1024];
                                while (input.read(buffer) > 0) {
                                    fos.write(buffer);
                                }
                            }
                            
                            CallableStatement cs = con.prepareCall ("{call addsongtohistory(?, ?)}");
                            cs.setString(1,user.getUsername());  
                            cs.setString(2, songs.get(row).getId());
                            cs.executeUpdate();
                            cs.close();

                            
                            con.close();  

                            System.out.println("success");  

                            // TODO add your handling code here:
                            audioInputStream = 
                                    AudioSystem.getAudioInputStream(new File("C:\\Users\\lenovo\\Desktop\\temp.wav").getAbsoluteFile());
                        } catch (UnsupportedAudioFileException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (SQLException ex) {
                            Logger.getLogger(UserViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(UserViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            // create clip reference
                            clip = AudioSystem.getClip();
                        } catch (LineUnavailableException ex1) {
                            ex1.printStackTrace();
                        }

                        try {
                            // open audioInputStream to the clip
                            clip.open(audioInputStream);
                        } catch (LineUnavailableException ex2) {
                            ex2.printStackTrace();
                        } catch (IOException ex3) {
                            ex3.printStackTrace();
                        }

                        clip.loop(Clip.LOOP_CONTINUOUSLY); 
                        clip.start(); 
                        target.setValueAt("Stop", row, col);
                        lastRow = row;
                        lastCol = col;
                        songs.get(lastRow).toggleStatus();
                        prevPlaying = target;
                        
                    }
                }
            }
                
        });
        myTable.setBackground(new Color(0xF7F7F7));
        myTable.getTableHeader().setBackground(new Color(0xF7F7F7));
        jScrollPane1.setViewportView(myTable);
        sorter = new TableRowSorter<TableModel>(myTable.getModel());
        myTable.setRowSorter(sorter);
        jScrollPane1.validate();
        jScrollPane1.setVisible(true);
        jScrollPane1.getViewport().setBackground(new Color(0xF7F7F7));
    }
}
