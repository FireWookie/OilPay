package libraries.decompose.common.producer

interface EventsProducerDelegate<Event : Any> : EventsProducer<Event> {

    fun dispatch(event: Event)
}