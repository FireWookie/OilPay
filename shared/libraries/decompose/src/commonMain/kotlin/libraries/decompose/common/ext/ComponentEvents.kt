package libraries.decompose.common.ext

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow
import libraries.decompose.common.producer.EventsProducer

fun <E : Any> Value<ChildStack<*, *>>.stackComponentEvents(): Flow<E> {
    return this
        .asStateFlow()
        .map { stack -> stack.active.instance }
        .filterIsInstance<EventsProducer<E>>()
        .flatMapLatest { component -> component.events }
}
