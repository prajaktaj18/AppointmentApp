package com.application.appointmentapp

import android.content.Context
import com.application.appointmentapp.model.PackageModel

class PackageListGenrator {
    fun getHairCutData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("Step Cut","300 rs.","*Including Taxes"))
        packageData.add(PackageModel("Layer Cut","300 rs.","*Including Taxes"))
        packageData.add(PackageModel("Multi-layer Cut","400 rs.","*Including Taxes"))
        packageData.add(PackageModel("Advance step Cut","300 rs.","*Including Taxes"))
        packageData.add(PackageModel("Feather Cut","200 rs.","*Including Taxes"))
        return packageData
    }

    fun getHairColorData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("Temporary","500 rs.","*Including Taxes"))
        packageData.add(PackageModel("Permanent","1500 Rs. +","*Including Taxes"))
        packageData.add(PackageModel("Touch Up","300 rs.","*Including Taxes"))
        packageData.add(PackageModel("Global","2000 rs.","*Including Taxes"))
        packageData.add(PackageModel("Highlight","1100 Rs. +","*Including Taxes"))
        return packageData
    }

    fun getSpaData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("Day Spa","10000 rs.","The main feature of this type is that it does not offer accommodation and visitors can go for an hour or a day as they please. Clients can choose single treatments or services like a massage, facial, mani / pedi, or they can combine spa services, take a half day package or a full day pamper. Some Day Spas also offer fitness facilities and individual training programmes."))
        packageData.add(PackageModel("Pamper Spa","5000 rs.","Designed to spoil and pamper clients who want to de-stress without being concerned about their diet. The emphasis is on relaxation, fun and a little decadence combined with a variety of Spa services where clients can enjoy a wonderful Aromatherapy Massage or pop in for a luxury manicure."))
        packageData.add(PackageModel("Medi Spa","80000 rs.","This is where wellness treatments or procedures are carried out under the management of a Medical Doctor. Other medical services are also offered and include Nutritionists, Chiropractors, Sports Injury Medicine and Physical Therapy."))
        return packageData
    }


    fun getMakeupData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("Simple Makeup","1000 rs.","*Including Taxes"))
        packageData.add(PackageModel("Party Makeup","1500 rs.","*Including Taxes"))
        packageData.add(PackageModel("Engagement Makeup","2500 rs.","*Including Taxes"))
        return packageData
    }

    fun getFacialData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("All-type skin facial","500 Rs. +","*Including Taxes"))
        packageData.add(PackageModel("Advance Equipment Facial","1200 rs.","*Including Taxes"))
        packageData.add(PackageModel("Skin Treatment","5000 rs.","*Including Taxes"))
        return packageData
    }

    fun getBridalData(context: Context): ArrayList<PackageModel> {
        val packageData = ArrayList<PackageModel>()
        packageData.add(PackageModel("3D Makeup","6000 rs.","All types of Looks including Jewellery\n*Including Taxes"))
        packageData.add(PackageModel("HD Makeup","7000 rs.","*Including Taxes"))
        return packageData
    }

}