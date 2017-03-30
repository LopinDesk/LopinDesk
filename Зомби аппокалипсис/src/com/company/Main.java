package com.company;




import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        JFrame JFrame = new JFrame("Симулятор выживания в зомби апокалипсисе");
        JPanel JPanel = new JPanel();
        JPanel.setLayout(null);
        JFrame.add(JPanel);
        JFrame.setSize(500, 500);
        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setLocation(400, 150);
        JFrame.setResizable(false);
        JFrame.setVisible(true);

        JPanel.setBackground(Color.white);
        JButton button1 = new JButton("Начать игру");
        JButton button2 = new JButton("О игре");
        button1.grabFocus();
        button2.grabFocus();
//Игра
        int[] dung = {0};
        int[] hung = {10};
        int[] hp = {20};
        int[] mind = {1};

        int[] hpzombie = {10};


        int[] damage = {2};
        int[] edamage = {1};
//Вещи
        int[] food = {0};
        int[] knife = {0};
        int[] knifede = {0};
        int[] wearknife = {0};
        int[] book = {0};

//кВещи
        JButton button3 = new JButton("Профиль");
        JButton button5 = new JButton("Инвентарь");

        JLabel label1 = new JLabel("Действия:");
        JButton button4 = new JButton("Ходить по городу");

//        JLabel ins = new JLabel("Ваши вещи:");
        JLabel slot1 = new JLabel(food[0] + " банок тушенки");




        JButton back3 = new JButton("Уйти");

        //Профиль
        JLabel brain = new JLabel("Интеллект: "+mind[0]);
        brain.setSize(200,30);
        brain.setLocation(50, 110);
        brain.setVisible(false);
        JPanel.add(brain);


        JLabel damageinfo = new JLabel("Сила: "+damage[0]);
        damageinfo.setSize(200,30);
        damageinfo.setLocation(50, 80);
        damageinfo.setVisible(false);
        JPanel.add(damageinfo);

        JLabel hung1 = new JLabel("Голод: "+hung[0]);
        hung1.setSize(200,30);
        hung1.setLocation(50, 50);
        hung1.setVisible(false);
        JPanel.add(hung1);

        JLabel hp1 = new JLabel("Здоровье: "+hp[0]);
        hp1.setSize(200,30);
        hp1.setLocation(50, 20);
        hp1.setVisible(false);
        JPanel.add(hp1);
        //кПрофиль

        //Инвентарь
        slot1.setVisible(false);
        JPanel.add(slot1);

        JButton eatfood = new JButton("Съесть тушенку");
        eatfood.setVisible(false);
        JPanel.add(eatfood);
        eatfood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(food[0] >= 1 & hung[0] <= 8 ){
                    hung[0] = hung[0] + 2;
                    --food[0];
                    JOptionPane.showMessageDialog(JPanel,"Вы успешно съели банку тушенки");
                    hung1.setText("Голод: "+hung[0]);
                    if (food[0] >= 1) {
                        if (food[0] == 1) {
                            slot1.setText(food[0] + " банка тушенки                                                                  ");
                        } else if (food[0] >= 2 & food[0] <= 4) {
                            slot1.setText(food[0] + " банки тушенки                                                                  ");
                        } else if (food[0] >= 5){
                            slot1.setText(food[0] + " банок тушенки                                                                 ");
                        }else{

                        }
                    }else{
                        slot1.setVisible(false);
                        eatfood.setVisible(false);
                    }
                }else if (food[0] <= 0 & hung[0] <= 8){
                    JOptionPane.showMessageDialog(JPanel,"У вас недостаточно тушенки");
                }else if (food[0] >= 1 & hung[0] >= 9){
                    JOptionPane.showMessageDialog(JPanel,"Вы уже сыты");
                }else if (food[0] <= 0 & hung[0] >= 9){
                    JOptionPane.showMessageDialog(JPanel,"У вас нету тушенки и Вы уже сыты");
                }else{

                }

            }
        });
        //кИнвентарь





        back3.setSize(100, 30);
        back3.setLocation(250, 300);
        back3.setVisible(false);
        JPanel.add(back3);

//        ins.setSize(400, 30);
//        ins.setLocation(50, 10);
//        ins.setVisible(false);
//        JPanel.add(ins);




        button3.setSize(150, 30);
        button3.setLocation(80, 20);
        button3.setVisible(false);
        JPanel.add(button3);

        button4.setSize(150, 30);
        button4.setLocation(80, 150);
        button4.setVisible(false);
        JPanel.add(button4);

        button5.setSize(150, 30);
        button5.setLocation(250, 20);
        button5.setVisible(false);
        JPanel.add(button5);

        label1.setSize(150, 30);
        label1.setLocation(200, 100);
        label1.setVisible(false);
        JPanel.add(label1);

        JLabel pvp1 = new JLabel("Хп зомби " + hpzombie[0]);
        JLabel pvp2 = new JLabel("Хп игрока " + hp[0]);
        JButton pvpb1 = new JButton("Ударить зомби в голову");
        JButton pvpb2 = new JButton("Ударить зомби по ногам");
        JLabel infopvp = new JLabel("");
        JLabel infopvp1 = new JLabel("");
        JLabel die = new JLabel("");
        JLabel kek = new JLabel("Информация боя");


        JButton hpup = new JButton("Ничего не делать");




        hpup.setSize(150, 30);
        hpup.setLocation(250, 150);
        hpup.setVisible(false);
        JPanel.add(hpup);


        pvpb1.setSize(200, 30);
        pvpb1.setLocation(50, 300);
        pvpb1.setVisible(false);
        JPanel.add(pvpb1);

        kek.setSize(200, 30);
        kek.setLocation(175, 100);
        kek.setVisible(false);
        JPanel.add(kek);

        die.setSize(200, 30);
        die.setLocation(300, 175);
        die.setVisible(false);
        JPanel.add(die);

        infopvp.setSize(300, 30);
        infopvp.setLocation(100, 200);
        infopvp.setVisible(false);
        JPanel.add(infopvp);

        infopvp1.setSize(300, 30);
        infopvp1.setLocation(100, 150);
        infopvp1.setVisible(false);
        JPanel.add(infopvp1);

        pvpb2.setSize(200, 30);
        pvpb2.setLocation(280, 300);
        pvpb2.setVisible(false);
        JPanel.add(pvpb2);

        pvp1.setSize(150, 30);
        pvp1.setLocation(50, 20);
        pvp1.setVisible(false);
        JPanel.add(pvp1);

        pvp2.setSize(150, 30);
        pvp2.setLocation(300, 20);
        pvp2.setVisible(false);
        JPanel.add(pvp2);

        hpup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hp[0] <= 18) {
                    ++hp[0];
                    ++hp[0];
                    --hung[0];
                    JOptionPane.showMessageDialog(JPanel, "Вы успешно востановили немного своего здоровья");
                    hp1.setText("Здоровья: " + hp[0]);
                    hung1.setText("Голода: " + hung[0]);
                }else {
                    JOptionPane.showMessageDialog(JPanel, "У вас и так максимальное здоровье");
                }
                if(hung[0] <= 0){
                    JOptionPane.showMessageDialog(JPanel, "Вы умерли от голода");
                    JFrame.dispose();
                }
            }
        });

        back3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setVisible(true);
                button4.setVisible(true);
                button5.setVisible(true);
                label1.setVisible(true);
                hpup.setVisible(true);

                pvp1.setVisible(false);
                pvp2.setVisible(false);
                pvpb1.setVisible(false);
//                pvpb2.setVisible(true);
                infopvp.setVisible(false);
                infopvp1.setVisible(false);
                die.setVisible(false);
                kek.setVisible(false);
                back3.setVisible(false);

            }
        });



        JButton back1 = new JButton("Назад");
        back1.setSize(100, 30);
        back1.setLocation(150, 400);
        back1.setVisible(false);
        JPanel.add(back1);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setVisible(true);
                button4.setVisible(true);
                button5.setVisible(true);
                label1.setVisible(true);
                back1.setVisible(false);
                hung1.setVisible(false);
                hp1.setVisible(false);
                damageinfo.setVisible(false);
                hpup.setVisible(true);
                brain.setVisible(false);
            }
        });
        //слоты


        JLabel slot2 = new JLabel(knife[0]+" ножей                                     ");
        slot2.setVisible(false);
        JPanel.add(slot2);

        JLabel knifed = new JLabel("Прочность у ножа:                       "+knifede[0]);
        knifed.setVisible(false);
        JPanel.add(knifed);

        JButton knifewear = new JButton("Надеть нож");
        knifewear.setVisible(false);
        JPanel.add(knifewear);

        JButton unwearknife = new JButton("Снять нож");
        unwearknife.setVisible(false);
        JPanel.add(unwearknife);

        JLabel slot3 = new JLabel();
        slot3.setVisible(false);
        JPanel.add(slot3);

        JButton readbook = new JButton("Прочитать книгу");
        readbook.setVisible(false);
        JPanel.add(readbook);

        unwearknife.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                knifed.setVisible(false);
                slot2.setVisible(true);
                    --wearknife[0];
                    ++knife[0];
                    damage[0] = damage[0] - 3;
                if (knife[0] == 1) {
                    slot2.setText(knife[0] + " нож                  ");
                } else if (knife[0] >= 2 & knife[0] <= 4) {
                    slot2.setText(knife[0] + " ножа                 ");
                } else {
                    slot2.setText(knife[0] + " ножей                ");
                }
               slot2.setText(knife[0]+" ножей                                     ");
                knifewear.setVisible(true);
                unwearknife.setVisible(false);
            }
        });

        readbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++mind[0];
                --book[0];
                --hung[0];
                JOptionPane.showMessageDialog(JPanel,"Вы успешно прочитали книгу и стали немножко умнее");
                if(book[0] == 1){
                    slot3.setText(book[0] + " книга                                                                                                      ");
                }else if(book[0] >= 2 & book[0] <= 4){
                    slot3.setText(book[0] + " книги                                                                                                       ");
                }else if (book[0] >= 5){
                    slot3.setText(book[0] + " книг                                                                                                       ");
                }else{
                   slot3.setVisible(false);
                   readbook.setVisible(false);
                }
                if(hung[0] <= 0){
                    JOptionPane.showMessageDialog(JPanel,"Вы умерли от голода");
                    JFrame.dispose();
                }
            }
        });



        knifewear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                knifewear.setVisible(false);
                unwearknife.setVisible(true);
                knifed.setVisible(true);
                damage[0] = damage[0] + 3;
                ++wearknife[0];
                --knife[0];
                if(knifede[0] == 0){
                    knifede[0] = 3;
                    knifed.setText(knifede[0]+" Прочность у ножа:                                    ");
                }else{

                }
                if (knife[0] >= 1 ){
                    slot2.setVisible(true);
                    if (knife[0] == 1) {
                        slot2.setText(knife[0] + " нож                  ");
                    } else if (knife[0] >= 2 & knife[0] <= 4) {
                        slot2.setText(knife[0] + " ножа                 ");
                    } else if(knife[0] >=5 ){
                        slot2.setText(knife[0] + " ножей                ");
                    }else{
                        slot2.setVisible(false);
                    }
                }else{
                    slot2.setVisible(false);
                }

            }
        });

        JButton back2 = new JButton("Назад");
        back2.setVisible(false);
        JPanel.add(back2);



        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setVisible(true);
                button4.setVisible(true);
                button5.setVisible(true);
                label1.setVisible(true);
                hpup.setVisible(true);
                unwearknife.setVisible(false);
                JPanel.setLayout(null);

                back2.setVisible(false);
//                ins.setVisible(false);
                slot1.setVisible(false);
                slot2.setVisible(false);
                eatfood.setVisible(false);
                knifed.setVisible(false);
                knifewear.setVisible(false);
                slot3.setVisible(false);
                readbook.setVisible(false);

            }
        });
        //кСлоты

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel.setLayout(new FlowLayout());
                button3.setVisible(false);
                button4.setVisible(false);
                button5.setVisible(false);
                label1.setVisible(false);
                back2.setVisible(true);
//                ins.setVisible(true);
                hpup.setVisible(false);

                if (book[0] >= 1){
                slot3.setVisible(true);
                readbook.setVisible(true);
                if(book[0] ==1){
                    slot3.setText(book[0] + " книга                                                                                                      ");
                }else if(book[0] >= 2 & book[0] <= 4){
                    slot3.setText(book[0] + " книги                                                                                                       ");
                }else{
                    slot3.setText(book[0] + " книг                                                                                                        ");
                }

                }

                if (food[0] >= 1) {
                    eatfood.setVisible(true);
                }else{

                }
                if (food[0] >= 1) {
                    slot1.setVisible(true);
                    if (food[0] == 1) {
                        slot1.setText(food[0] + " банка тушенки                                                                      ");
                    } else if (food[0] >= 2 & food[0] <= 4) {
                        slot1.setText(food[0] + " банки тушенки                                                                      ");
                    } else {
                        slot1.setText(food[0] + " банок тушенки                                                                      ");
                    }
                }
               if(knife[0] >= 1 ){
                    slot2.setVisible(true);

               }else{

               }
               if(wearknife[0] == 1) {
                   unwearknife.setVisible(true);
                   knifed.setVisible(true);
                   knifed.setText(knifede[0]+" Прочность у ножа:                                    ");
                   if (knife[0] >= 1) {
                       if (knife[0] == 1) {
                           slot2.setText(knife[0] + " нож                  ");
                       } else if (knife[0] >= 2 & knife[0] <= 4) {
                           slot2.setText(knife[0] + " ножа                 ");
                       } else if(knife[0] >=5 ){
                           slot2.setText(knife[0] + " ножей                ");
                       }else{
                       }
                       slot2.setVisible(true);
                   } else {

                   }
               }
                   if(wearknife[0] == 0 & knife[0] >= 1){
                       knifewear.setVisible(true);
                       slot2.setVisible(true);
                       if (knife[0] >= 1 ){
                           slot2.setVisible(true);
                           if (knife[0] == 1) {
                               slot2.setText(knife[0] + " нож                  ");
                           } else if (knife[0] >= 2 & knife[0] <= 4) {
                               slot2.setText(knife[0] + " ножа                 ");
                           } else if(knife[0] >=5 ){
                               slot2.setText(knife[0] + " ножей                ");
                           }else{
                           }
                   }
               }

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setVisible(false);
                button4.setVisible(false);
                button5.setVisible(false);
                label1.setVisible(false);
                back1.setVisible(true);
                hung1.setVisible(true);
                damageinfo.setVisible(true);
                hp1.setVisible(true);
                hpup.setVisible(false);
                brain.setVisible(true);

                hung1.setText("Голод: "+hung[0]);
                brain.setText("Интеллект: "+mind[0]);
                damageinfo.setText("Сила: "+damage[0]);
            }
        });
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rd2 = (int) (Math.random() * 100 + 1);


                if (rd2 <= 20) {
                    JOptionPane.showMessageDialog(JPanel, "Вы нашли банку консерв");
                    ++food[0];
                    --hung[0];
                    hung1.setText("Голод: "+hung[0]);

                } else if (rd2 >= 21 & rd2 <= 50) {
                    JOptionPane.showMessageDialog(JPanel, "Вы нашли банку консерв, но наткнулись на зомби");
                    hpzombie[0] = 10;
                    ++food[0];
                    --hung[0];
                    hung1.setText("Голод: "+hung[0]);
                    pvp1.setText("Хп зомби " + hpzombie[0]);
                    infopvp.setText("");
                    infopvp1.setText("");
                    die.setText("");
                    button3.setVisible(false);
                    button4.setVisible(false);
                    button5.setVisible(false);
                    label1.setVisible(false);
                    hpup.setVisible(false);

                    pvp1.setVisible(true);
                    pvp2.setVisible(true);
                    pvpb1.setVisible(true);
//                pvpb2.setVisible(true);
                    infopvp.setVisible(true);
                    infopvp1.setVisible(true);
                    die.setVisible(true);
                    kek.setVisible(true);
                } else if (rd2 >= 51 & rd2 <= 70){
                    --hung[0];
                    JOptionPane.showMessageDialog(JPanel, "Вы ничего не нашли");
                }
                if (rd2 >= 71 & rd2 <= 100){
                    ++book[0];
                    --hung[0];
                    JOptionPane.showMessageDialog(JPanel,"Вы нашли книгу");
                }
                if(hung[0] <= 0){
                    JOptionPane.showMessageDialog(JPanel,"Вы умерли от голода");
                    JFrame.dispose();
                }else{

                }

            }


        });


        pvpb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pvp1.setText("Хп игрока: "+hp[0]);
                int rd = (int) (Math.random() * 2 + 1);
                int rd1 = (int) (Math.random() * 2 + 1);
                if (rd == 1 & hpzombie[0] >= 1 & hp[0] >= 1) {
                    infopvp.setText("Вы промазали");

                    pvp1.setText("Хп зомби " + hpzombie[0]);
                    if (rd1 == 1) {
                        infopvp1.setText("Зомби промазал");
                        rd1 = 0;
                    } else if (rd1 == 2) {
                        hp[0] = hp[0] - edamage[0];
                        infopvp1.setText("Зомби попал");
                        pvp2.setText("Хп игрока " + hp[0]);
                        rd1 = 0;
                    } else {

                    }
                } else if (rd == 2 & hpzombie[0] >= 1 & hp[0] >= 1) {
                    hpzombie[0] = hpzombie[0] - damage[0];
                    infopvp.setText("Вы попали");
                    pvp1.setText("Хп зомби " + hpzombie[0]);
                    rd = 0;
                    if (rd1 == 1) {
                        infopvp1.setText("Зомби промазал");
                        rd1 = 0;
                    } else if (rd1 == 2) {
                        hp[0] = hp[0] - edamage[0];
                        infopvp1.setText("Зомби попал");
                        pvp2.setText("Хп игрока " + hp[0]);
                        rd1 = 0;
                    } else{

                    }
                    if (hpzombie[0] <= 0 & hp[0] >= 1) {
                        die.setText("Вы убили зомби");
                        if(knifede[0] >= 1) {
                            --knifede[0];
                        }else{

                        }

                        if(knifede[0] == 0 & wearknife[0] == 1){
                            --wearknife[0];
                            damage[0] = damage[0] - 3;
                            JOptionPane.showMessageDialog(JPanel,"У вас сломался нож");
                        }else{

                        }
                        hp1.setText("Здоровья: "+hp[0]);
                        pvpb1.setVisible(false);
                        back3.setVisible(true);
                        rd1 = 0;
                        rd = 0;
                        int proc = (int) (Math.random()*100+1);
                       if (proc <= 20){
                           die.setText("С зомби вам выпал нож");
                           ++knife[0];
                           proc = 0;
                       }else{
                           proc = 0;
                       }
                    } else{

                    }
                        if (hpzombie[0] >= 1 & hp[0] <= 0) {
                        JOptionPane.showMessageDialog(JPanel,"Вас съел зомби");
                        JFrame.dispose();

                    } else{

                        }
                        if (hpzombie[0] == 0 & hp[0] == 0) {
                            JOptionPane.showMessageDialog(JPanel,"Вы оба умерли");
                             JFrame.dispose();
                    }
                }
            }
        });


//кИгра


        button1.setSize(200, 30);
        button1.setLocation(100, 50);
        button2.setSize(200, 30);
        button2.setLocation(150, 200);
        JPanel.add(button2);
        JPanel.add(button1);
        button1.grabFocus();
        button2.grabFocus();

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JPanel, "В этой игре Вы будете выживать в зомби мире");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                button1.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(true);
                button4.setVisible(true);
                button5.setVisible(true);
                label1.setVisible(true);
                hpup.setVisible(true);

            }
        });
    }
}
