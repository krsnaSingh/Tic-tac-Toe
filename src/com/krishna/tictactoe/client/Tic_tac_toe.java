package com.krishna.tictactoe.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;




public class Tic_tac_toe implements EntryPoint {

	private Button[][] board = new Button[3][3];
    private boolean xTurn = true;
    private PopupPanel winnerPopup;

    @Override
    public void onModuleLoad() {
       
        VerticalPanel panel = new VerticalPanel();
        panel.setStyleName("vertical-panel");

       
        Grid grid = new Grid(3, 3);

       
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;

                board[row][col] = new Button("");
                board[row][col].setStyleName("board-button");

                
                board[row][col].addClickHandler(event -> {
                    if (board[r][c].getText().equals("")) {
                        board[r][c].setText(xTurn ? "X" : "O");
                        xTurn = !xTurn;
                        checkForWinnerOrDraw();
                    }
                });

                grid.setWidget(row, col, board[row][col]);
            }
        }

        panel.add(grid);
        RootPanel.get("gameArea").add(panel);

       
        winnerPopup = new PopupPanel();
        winnerPopup.setStyleName("winner-popup");
        winnerPopup.setGlassEnabled(true); 
    }

    private void checkForWinnerOrDraw() {
        
        for (int i = 0; i < 3; i++) {
            if (checkEqual(board[i][0], board[i][1], board[i][2])) {
                announceWinner(board[i][0].getText());
                return;
            }
            if (checkEqual(board[0][i], board[1][i], board[2][i])) {
                announceWinner(board[0][i].getText());
                return;
            }
        }

        if (checkEqual(board[0][0], board[1][1], board[2][2])) {
            announceWinner(board[0][0].getText());
            return;
        }
        if (checkEqual(board[0][2], board[1][1], board[2][0])) {
            announceWinner(board[0][2].getText());
            return;
        }

      
        boolean draw = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().equals("")) {
                    draw = false;
                    break;
                }
            }
        }

        if (draw) {
            announceWinner("Draw");
        }
    }

    private boolean checkEqual(Button b1, Button b2, Button b3) {
        return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    private void announceWinner(String winner) {
        Label winnerMessage = new Label();
        winnerMessage.setStyleName("winner-message"); 

        if (winner.equals("Draw")) {
            winnerMessage.setText("It's a Draw!");
        } else {
            winnerMessage.setText(winner + " Wins!");
        }

        winnerPopup.clear(); 

       
        Button restartButton = new Button("Restart Game");
        
        restartButton.addClickHandler(event -> resetBoard());
        restartButton.setStyleName("restart-game");

        VerticalPanel popupContent = new VerticalPanel();
        popupContent.add(winnerMessage);
        popupContent.add(restartButton);

        winnerPopup.setWidget(popupContent);
        winnerPopup.center(); 
        winnerPopup.show(); 
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText("");
            }
        }
        xTurn = true;
        winnerPopup.hide(); 
    }
	 
}
