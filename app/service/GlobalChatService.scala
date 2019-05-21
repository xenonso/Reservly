package service

import actorRegister.GlobalChatActorRegister
import akka.actor.ActorSystem
import model.GlobalChatMessage
import play.api.mvc.{AnyContent, Request}
import serializer.ChatMessageJsonSerializer
import validation.chatMessage.ChatMessageValidator

class GlobalChatService {

  def handleGlobalChatMessageBroadcast(actorSystem: ActorSystem, request: Request[AnyContent]): Boolean = {
    val chatMessage = ChatMessageJsonSerializer.fromJson(request.body.asJson.get.toString())
    val isMessageValid = ChatMessageValidator.validate(chatMessage)

    if(isMessageValid) {
      broadcastMessage(actorSystem, chatMessage)
    }

    isMessageValid
  }

  private def broadcastMessage(actorSystem: ActorSystem, chatMessage: GlobalChatMessage): Unit = {
    val globalChatActorRegister = new GlobalChatActorRegister(actorSystem)
    val chatMessageAsJson = s"[GLOBAL_CHAT] ${ChatMessageJsonSerializer.toJson(chatMessage)}"

    globalChatActorRegister.broadcastMessage(chatMessageAsJson)
  }
}