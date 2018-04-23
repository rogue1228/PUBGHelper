package com.mc_jh.pubghelper.data.type

/**
 * Created by Administrator on 2018-04-23.
 */
sealed class Weapon {
    class SMG() : Weapon()
    class AR() : Weapon()
    class SR() : Weapon()
    class Pistol() : Weapon()
    class MeleeWeapon() : Weapon()
}