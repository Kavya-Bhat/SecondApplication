package com.example.secondapplication;

public class LeftOrRightChoice
{
    int one;
    private int index = 1;
    final  private Integer[] cartoon= {
            R.drawable.kaalia,
            R.drawable.oggy,
            R.drawable.pikachu,
            R.drawable.ninja
    };

    final private String[] profileName = {
            "Kaalia",
            "Oggy",
            "Pikachu",
            "Hattori"
    };

    final private String[] profileDescription = {
            "mein bheem ko haraa ke rahunga",
            "yeh kyaaa!! mujhe bachaao bade bhaiyaa",
            "pika....pika-pi!!!",
            "ding ding ding"
    };
   
    public String nextDescription(int one)
    {
        return profileDescription[one];
    }

    public Integer nextImage()
    {
        one = getIndex();
        return cartoon[one];
    }
    public String nextName()
    {
        return profileName[one];
    }
    public String nextName(int one)
    {
        return profileName[one];
    }

    private int getIndex()
    {
        if(index < cartoon.length)
            return index++;
        else
            return index = 0;
    }
    public int getOne()
    {
        return one;
    }
}





