package libraries.decompose.common.producer

import kotlinx.coroutines.flow.Flow

interface EventsProducer<out Event: Any> {

    val events: Flow<Event>
}