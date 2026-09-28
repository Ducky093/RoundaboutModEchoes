package net.hydra.jojomod.stand.powers;

import net.hydra.jojomod.event.index.PowerIndex;
import net.hydra.jojomod.event.powers.StandPowers;
import net.hydra.jojomod.stand.powers.elements.PowerContext;
import net.hydra.jojomod.stand.powers.presets.NewDashPreset;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

import static net.hydra.jojomod.event.index.PowerIndex.POWER_4_SNEAK;

public class PowersSexPistols extends NewDashPreset {
    public PowersSexPistols(LivingEntity self) {
        super(self);
    }

    @Override
    public StandPowers generateStandPowers(LivingEntity entity) {
        return new PowersSexPistols(entity);
    }

    @Override
    public boolean isWip(){return true;}
    public Component ifWipListDevStatus(){
        return Component.translatable(  "roundabout.dev_status.active").withStyle(ChatFormatting.WHITE);
    }
    @Override
    public Component ifWipListDev(){
        return Component.literal(  "a duck").withStyle(ChatFormatting.WHITE);
    }
 //   @Override
   // public StandEntity getNewStandEntity() {
    //    return ModEntities.SEXPISTOL.create(this.getSelf().level());
   // }

    @Override
    public void powerActivate(PowerContext context) {
        switch (context)
        {
            case SKILL_1_NORMAL -> {
       //         itemSendClient();
            }
            case SKILL_1_CROUCH -> {
         //       itemKickClient();
            }
            case SKILL_2_NORMAL-> {
         //       targetSelectClient();
            }
            case SKILL_2_CROUCH-> {
          //      sexPistolItemGrabClient();
            }
            case SKILL_3_NORMAL -> {
                dash();
            }
            case SKILL_3_CROUCH -> {
         //       projectileBlockingClient();
            }
            case SKILL_4_NORMAL -> {
         //   feedSexPistolsClient();
            }
            case SKILL_4_CROUCH -> {
               reconClient();
            }
           }
        }


   @Override
    public boolean setPowerOther(int move, int lastMove) {
        switch (move) {
          /*  case PowerIndex.POWER_1 -> {
                return itemSend();
            }
            case PowerIndex.POWER_1_CROUCH -> {
                return itemKick();
            }
            case PowerIndex.POWER_2 -> {
                return targetSelect();
            }
            case PowerIndex.POWER_3_CROUCH -> {
                return projectileBlocking();
            }
            case PowerIndex.POWER_4 -> {
                return feedSexPistols();
            }  */
            case POWER_4_SNEAK -> {
         //       return recon();
            }
        }
        return super.setPowerOther(move,lastMove);  
 }
   public void reconClient() {
        if (!onCooldown(PowerIndex.SKILL_4_SNEAK)) {
            this.setCooldown(PowerIndex.SKILL_4_SNEAK, 20);

            tryPower(POWER_4_SNEAK);
            tryPowerPacket(POWER_4_SNEAK);
        }
    }
   /* public boolean recon() {
        public void toggleControlModeClient() {
            if (isPiloting()) {
                if (this.self instanceof Player PE) {
                    IPlayerEntity ipe = ((IPlayerEntity) PE);
                    ipe.roundabout$setIsControlling(0);
                }
                this.setSomeTicks(5);
                tryIntToServerPacket(PacketDataIndex.INT_UPDATE_PILOT, 0);
            } else {
                StandEntity entity = this.getStandEntity(this.self);
                int L = 0;
                if (entity != null) {
                    L = entity.getId();
                }
                tryIntToServerPacket(PacketDataIndex.INT_UPDATE_PILOT, L);
            }
            this.setCooldown(PowerIndex.SKILL_4, 20);
        }
    }*/
@Override
    public boolean isSecondaryStand(){
        return true;
    }

}
