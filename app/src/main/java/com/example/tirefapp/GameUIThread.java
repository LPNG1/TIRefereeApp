package com.example.tirefapp;

import android.widget.TextView;

import java.text.MessageFormat;

public class GameUIThread extends Thread {

    private TextView gameTime, anchorText, gameStateText;

    public GameUIThread(TextView gameTime, TextView anchorText, TextView gameStateText) {
        this.gameTime = gameTime;
        this.anchorText = anchorText;
        this.gameStateText = gameStateText;
    }

    @Override
    public void run() {
        while (ServerReader.getInstance().getSecondsPassed() <= 210) {
            gameTime.setText(MessageFormat.format("Game Time: {0}:{1}", ServerReader.getInstance().getMinutes(), ServerReader.getInstance().getSeconds()));
            anchorText.setText(MessageFormat.format("Anchors: {0}/2", ServerReader.getInstance().anchorsRaised()));
            gameStateText.setText(ServerReader.getInstance().getGameState());
        }

        GameActivity.getInstance().startPostGame();
    }

}
