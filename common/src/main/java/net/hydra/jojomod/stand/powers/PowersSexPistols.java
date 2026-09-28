package net.hydra.jojomod.stand.powers;

import net.hydra.jojomod.Roundabout;
import net.hydra.jojomod.access.IEntityAndData;
import net.hydra.jojomod.block.InvisiBlockEntity;
import net.hydra.jojomod.block.ModBlocks;
import net.hydra.jojomod.block.RoundaboutAttackBlock;
import net.hydra.jojomod.client.ClientNetworking;
import net.hydra.jojomod.client.StandIcons;
import net.hydra.jojomod.client.hud.StandHudRender;
import net.hydra.jojomod.event.AbilityIconInstance;
import net.hydra.jojomod.event.ModParticles;
import net.hydra.jojomod.event.index.PowerIndex;
import net.hydra.jojomod.event.index.SoundIndex;
import net.hydra.jojomod.event.powers.CooldownInstance;
import net.hydra.jojomod.event.powers.StandPowers;
import net.hydra.jojomod.event.powers.StandUser;
import net.hydra.jojomod.networking.ModPacketHandler;
import net.hydra.jojomod.sound.ModSounds;
import net.hydra.jojomod.stand.powers.elements.PowerContext;
import net.hydra.jojomod.stand.powers.presets.NewDashPreset;
import net.hydra.jojomod.util.MainUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;

import javax.annotation.Nullable;
import java.util.List;

public class PowersSexPistols extends NewDashPreset {
    public PowersSexPistols(LivingEntity self) {
        super(self);
    }

    @Override
    public StandPowers generateStandPowers(LivingEntity entity) {
        return new PowersSexPistols(entity);
    }

    @Override
    /**Override to add disable config*/
    public boolean isStandEnabled() {
        return true
    }
    @Overide
    public boolean iswip(){return true;}
    public Component ifWipListDevStatus(){
        return Component.translatable(  "roundabout.dev_status.active").withStyle(ChatFormatting.WHITE);
    }
    @Override
    public Component ifWipListDev(){
        return Component.literal(  "a duck").withStyle(ChatFormatting.WHITE);
    }
    @Override
    public StandEntity getNewStandEntity() {
        return ModEntities.SEXPISTOL.create(this.getSelf().level());
    }

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
            case PowerIndex.POWER_4_CROUCH -> {
                return recon();
            }
        }
        return super.setPowerOther(move,lastMove);  
 }
   public void reconClient() {
        if (!onCooldown(PowerIndex.SKILL_4_SNEAK)) {
            this.setCooldown(PowerIndex.SKILL_4_SNEAK, 20);

            tryPower(recon);
            tryPowerPacket(recon);
        }
    }
    public boolean recon() {
    /*    public void toggleControlModeClient() {
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
        }*/
    }
@Override
    public boolean isSecondaryStand(){
        return true;
    }

}
