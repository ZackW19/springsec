package pl.zwa.springsec.models;


//wzorzec prjektowy BUILDER, który pomaga przy tworzeniu obiektów dla więcej niż 4 lub 5 argumentów
public class Player {
    private String name;
    private int lvl;
    private int attack;
    private int defence;
    private String nickname;

    private Player(Builder builder) {

        name = builder.name;
        lvl = builder.lvl;
        attack = builder.attack;
        defence = builder.defence;
        nickname = builder.nickname;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static class Builder{   //tworzymy klasę statyczną Builder
        private String name;
        private int lvl;
        private int attack;
        private int defence;
        private String nickname;

        public Builder(String name){   //tworzymy konstruktor Builder'a
            this.name = name;
        }
        //tworzymy settery i zmieniamy void na Builder, dodajemy 'return this'
        public Builder setLvl(int lvl) {
            this.lvl = lvl;
            return this;
        }

        public Builder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder setDefence(int defence) {
            this.defence = defence;
            return this;
        }

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }

}

